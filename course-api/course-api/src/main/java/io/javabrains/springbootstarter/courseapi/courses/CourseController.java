package io.javabrains.springbootstarter.courseapi.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.courseapi.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	//Get request by default
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable("courseId") String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") String id) {
		courseService.deleteCourse(id);
	}
}
