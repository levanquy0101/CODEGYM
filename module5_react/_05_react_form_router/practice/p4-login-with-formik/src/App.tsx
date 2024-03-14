import React, {ReactNode, useState} from 'react';
import './App.css';
import {Formik} from "formik";
import {FormikErrors} from "formik/dist/types";

interface formValid {
    value: string,
    error: string
}

interface form {
    email: formValid,
    password: formValid
}

function App() {
    const REGEX = {
        email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
    };

    const frm: form = {
        email: {value: '', error: ''},
        password: {value: '', error: ''}
    }

    const [form, setForm] = useState(frm);

    function handleChange(event: any) {
        const {name, value} = event.target;
        // @ts-ignore
        setForm((prevForm) => ({
            ...prevForm,
            [name]: {
                // @ts-ignore
                ...prevForm[name],
                value: value,
            },
        }));
    }

    function handleValidate() {
        const errors: FormikErrors<any> = {};
        if (!form.email.value) {
            errors.email = "Required";
        } else if (!REGEX.email.test(form.email.value)) {
            errors.email = "Invalid email address";
        }

        if (!form.password.value) {
            errors.password = "Required";
        }

        return errors;
    }

    function handleSubmit() {
        alert("Login in successfully!!!");
    }

    return (
        <div>
            <h1>Sign up</h1>
            <Formik
                initialValues={form}
                validate={handleValidate}
                onSubmit={handleSubmit}
            >
                {({errors, handleSubmit}) => (
                    <form onSubmit={handleSubmit}>
                        <div
                            className={`custom-input ${
                                errors.email ? "custom-input-error" : ""
                            }`}
                        >
                            <label>Email</label>
                            <input
                                name="email"
                                value={form.email.value || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.email as ReactNode}</p>
                        </div>
                        <div
                            className={`custom-input ${
                                errors.password ? "custom-input-error" : ""
                            }`}
                        >
                            <label>Password</label>
                            <input
                                type="password"
                                name="password"
                                value={form.password.value || ""}
                                onChange={handleChange}
                            />
                            <p className="error">{errors.password as ReactNode}</p>
                        </div>
                        <button type="submit">Submit</button>
                    </form>
                )}
            </Formik>
        </div>
    );
}

export default App;
