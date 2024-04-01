// package com.ideapad.my_app;
// import java.util.List;

// import org.apache.catalina.connector.Request;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @RestController
// public class TopicController {

//     @Autowired
//     private TopicService topicService;

//     @RequestMapping("/topics")
//     public List<Topic> getAllTopics(){
//         return topicService.getAllTopics();
//     }

//     @RequestMapping("/topics/{id}")
//     public Topic getTopic(@PathVariable("id") String id){
//         int idInt = Integer.parseInt(id);
//         return topicService.getTopic(idInt);
//     }

//     // Add
//     // Another way to do the same thing as the below method
//     // @RequestMapping(method=RequestMethod.POST, value="/topics")
//     /*@PostMapping("/topics")
//     public void addTopic(@RequestBody Topic topic){
//         topicService.addTopic(topic);
//     }*/

//     // Update
//     // Another way
//     // @RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
//     @PutMapping("/topics/{id}")
//     public void updateTopic(@PathVariable("id") String id, @RequestBody Topic topic){
//         int idInt = Integer.parseInt(id);
//         topicService.updateTopic(idInt, topic);
//     }
// }
