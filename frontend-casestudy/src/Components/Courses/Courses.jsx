import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from "axios";



function Courses() {

    const [courses, setCourses] = useState([])

    useEffect(() => {
        loadCourses();
    }, [])

    const loadCourses = async () => {
        const results = await axios.get(`http://localhost:8082/api/courses/all`);
        console.log(results.data);
        setCourses(results.data);
    }

    const deleteCourse = async (id) => {
        await axios.delete(`http://localhost:8082/api/courses/delete/${id}`);
        loadCourses();
    };

    return (

        <div classNameName='container'>
            {/* margin top */}
            <div classNameName='py-20'>
                <table className="table border shadow" >
                    <thead>
                        <tr>
                            <th scope="col">Sr.No.</th>
                            <th scope="col">Course Id</th>
                            <th scope="col">Course Name</th>
                            <th scope="col">Course Time</th>
                            <th scope='col'>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            courses.map((courses, index) => (
                                <tr>
                                    <th scope="row" key={index}>{index + 1}</th>
                                    <td>{courses.courseId}</td>
                                    <td>{courses.courseName}</td>
                                    <td>{courses.courseTime}</td>
                                    <td>
                                        <Link
                                            className="btn btn-primary mx-2" to={`/viewcourse/${courses.courseId}`}>
                                            View
                                        </Link>
                                        <Link
                                            className="btn btn-outline-primary mx-2"
                                            to={`/editcourse/${courses.courseId}`}
                                        >
                                            Edit
                                        </Link>
                                        <button
                                            className="btn btn-danger mx-2"
                                            onClick={() => deleteCourse(courses.courseId)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))

                        }
                    </tbody>
                </table>
                <Link className="btn btn-warning" to="/addcourse">Add Course</Link>
            </div>
        </div>

    )
}

export default Courses