package io.javabrains.springbootstarter.courseapi.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>  {

	// has several methods like
	// getAllTopics
	// getTopic(String id)
	// deleteTopic(String id)
	// updateTopic(Topic t)
}
