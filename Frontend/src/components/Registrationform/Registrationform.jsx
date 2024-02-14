import React, { useState } from "react";
import "../Loginform/LogReg.css";
import { Link, useNavigate } from "react-router-dom";
import { signUp } from "../../services/auth";

const Signup = () => {
  const navigate = useNavigate();
  const [input, setInput] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    e.preventDefault();
    localStorage.setItem("Userdetail", JSON.stringify(input));
    navigate('/login');
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await signUp(input);

      if (res.data.token) {
        // Save the token to localStorage or a state if needed
        localStorage.setItem("token", res.data.token);
        
        console.log("Signup Successful");
        // Redirect or perform any other action upon successful registration
        // navigate('/login'); // You can redirect to the login page if needed
      } else if (res.data === "Email Already Exists") {
        console.log('Email Already Exists');
      } else {
        console.log('Invalid email');
      }
    } catch (error) {
      console.error('Error during registration:', error);
      // Handle errors appropriately, e.g., display an error message to the user
    }
  };

  return (
    <>
      <div className="Signup">
        <div className="SignupContainer">
          <div className="child">
            <h1 className="heading">CREATE AN ACCOUNT</h1>
            <form onSubmit={handleSubmit}>
              <div className="fields">
                <label className="labal">Your Name</label>
                <input
                  className="input"
                  type="text"
                  name="name"
                  required
                  value={input.name}
                  onChange={(e) =>
                    setInput({ ...input, [e.target.name]: e.target.value })
                  }
                />
                <label className="labal">Your Email</label>
                <input
                  className="input"
                  type="email"
                  name="email"
                  required
                  value={input.email}
                  onChange={(e) =>
                    setInput({ ...input, [e.target.name]: e.target.value })
                  }
                />
                <label className="labal">Password</label>
                <input
                  className="input"
                  type="password"
                  name="password"
                  required
                  value={input.password}
                  onChange={(e) =>
                    setInput({ ...input, [e.target.name]: e.target.value })
                  }
                />
              </div>
              <button className="btn">Register</button>
            </form>
            <div className="existingUser">
              <p className="Alreadyaccount">
                Already have an account? <Link to="/login">Login here</Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Signup;
