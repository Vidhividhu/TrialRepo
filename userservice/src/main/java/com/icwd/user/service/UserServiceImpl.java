package com.icwd.user.service;

import com.icwd.user.configuration.RestTemplateConfig;
import com.icwd.user.entities.Hotel;
import com.icwd.user.entities.Rating;
import com.icwd.user.entities.User;
import com.icwd.user.exception.ResourceNotFoundException;
import com.icwd.user.external.HotelService;
import com.icwd.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    // create a user
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // get the list of all the users
    @Override
    public List<User> getAllUser() {
    List<User> users=userRepository.findAll();
    for (User i:users) {
        ArrayList<Rating> ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings", ArrayList.class);
        logger.info("{}", ratings);
        i.setRatings(ratings);
    }

        return users;
    }

    //get the user based on the userId
    @Override
    public User getUser(String userId) {
//get user from the database with the help of the repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resourse is not found!!"));
        //fetch rating of the above user from rating service

        //first call api and store ratings in from of array
        Rating[] ratingOfUser= restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);
        logger.info("{}", ratingOfUser);

        //change array to arrayList

        List<Rating> ratings= Arrays.stream(ratingOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotel/d9cf3c8f-2a67-4c97-bed1-30fdfae1430b
            //this is done using getForObject
            //Hotel forObject1 = restTemplate.getForObject("http://localhost:8082/hotel/d9cf3c8f-2a67-4c97-bed1-30fdfae1430b", Hotel.class);
            
            //one more way is to do using the getForEntity. if we do this we get more information 
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+ rating.getHotelId(), Hotel.class);
//            Hotel hotel= forEntity.getBody();
//            logger.info("response status code: {}",forEntity.getStatusCode());

            //now here we will try to use openfeing client thing
            Hotel hotel =hotelService.getHotel(rating.getHotelId());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the hotel
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
