package com.example.courseservice.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.courseservice.dto.CourseDto;
import com.example.courseservice.entity.Course;
import com.example.courseservice.repository.CourseRepository;
import com.example.courseservice.service.CourseService;

import lombok.AllArgsConstructor;

import com.example.courseservice.exception.ResourceNotFoundException;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public CourseDto createCourse(CourseDto courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		Course createdCourse = courseRepository.save(course);
        return modelMapper.map(createdCourse, CourseDto.class);
	}

	@Override
	public CourseDto getCourseById(int courseId) {
		Optional<Course> courseOptional = courseRepository.findById(courseId);
        
        if (courseOptional.isPresent()) {
            CourseDto userDto = modelMapper.map(courseOptional.get(), CourseDto.class);
            return userDto;
        } else {
            throw new ResourceNotFoundException("Course", "id", courseId);
        }
	}

	@Override
	public List<CourseDto> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(user -> modelMapper.map(user, CourseDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public CourseDto updateCourse(CourseDto course) {
		 Optional<Course> courseOptional = courseRepository.findById(course.getCourseId());
	        
	        if (courseOptional.isPresent()) {
	            Course existingCourse = courseOptional.get();
	            existingCourse.setCourseName(course.getCourseName());
	            existingCourse.setCourseTime(course.getCourseTime());
	            
	            Course updatedCourse = courseRepository.save(existingCourse);
	            return modelMapper.map(updatedCourse, CourseDto.class);
	        } else {
	        	throw new ResourceNotFoundException("Course", "id", course.getCourseId());
	        }
	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.findById(courseId).orElseThrow(
                () -> new ResourceNotFoundException("Course", "id", courseId));
		courseRepository.deleteById(courseId);
		
	}

}
