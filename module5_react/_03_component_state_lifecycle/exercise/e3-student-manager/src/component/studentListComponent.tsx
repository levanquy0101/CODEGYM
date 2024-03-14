import React, {Component} from 'react';
import {Student} from "../model/student"

class StudentListComponent extends Component {
    students: Student[] = [
        {id: 1, name: "Quoc", age: 20, address: "a"},
        {id: 2, name: "Dung", age: 30, address: "b"},
        {id: 3, name: "Toan", age: 40, address: "c"},
    ];

    render() {
        return (
            <div>
                <h1>Student List</h1>
                <table>
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Age</td>
                    <td>Address</td>
                </tr>
                </thead>
                <tbody>
                {
                    this.students.map(s => (
                        <tr key={s.id}>
                            <td>{s.id}</td>
                            <td>{s.name}</td>
                            <td>{s.age}</td>
                            <td>{s.address}</td>
                        </tr>
                    ))
                }
                </tbody>
                </table>
            </div>
        );
    }
}

export default StudentListComponent;
