// package com.ideapad.my_app;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import org.springframework.stereotype.Service;

// @Service
// public class TopicService {

//     private List<Topic> topics = new ArrayList<>(Arrays.asList(
//         new Topic(1, "Spring Framework", "Spring Framework Description"),
//         new Topic(2, "Core Java", "Core Java Description"),
//         new Topic(3, "JavaScript", "JavaScript Description")
//     ));

//     public List<Topic> getAllTopics(){
//         return topics;
//     }

//     public Topic getTopic(int id){
//         return topics.stream().filter(t -> t.getId() == id).findFirst().get();
//     }

//     // Add
//     // public void addTopic(Topic topic){
//     //     topics.add(topic);
//     // }

//     // Update
//     public void updateTopic(int id, Topic topic){
//         for(int i = 0; i < topics.size(); i++){
//             Topic t = topics.get(i);
//             if(t.getId() == id){
//                 topics.set(i, topic);
//                 return;
//             }
//         }
//     }

// }
