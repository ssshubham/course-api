package io.javabrains.springbootstarter.courseapi.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>  {

	// has several methods like
	// getAllTopics
	// getTopic(String id)
	// deleteTopic(String id)
	// updateTopic(Topic t)
	
	public List<Course> findByTopicId(String id);
}
