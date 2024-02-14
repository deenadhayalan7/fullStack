import { Link, useNavigate } from "react-router-dom";
import React, { useState } from "react";
import { signIn } from '../../services/auth.js';
import "./LogReg.css";

const Loginform = () => {
  const navigate = useNavigate();
  const [input, setInput] = useState({
    email: "",
    password: "",
  });

  const handleLogin = async (e) => {
    e.preventDefault();
    
    try {
      // Call the signIn function from the backend
      const response = await signIn(input);

      if (response.data.token) {
        // Save the token to localStorage or a state if needed
        localStorage.setItem("token", response.data.token);
        
        // Redirect to the home page
        navigate('/');
      } else {
        alert("Wrong Email or Password");
      }
    } catch (error) {
      console.error('Error during login:', error);
      alert("An error occurred during login");
    }
  };

  return (
    <>
      <div className="Login">
        <div className="LoginContainer">
          <div className="child">
            <h1 className="headingLogin">LOGIN</h1>
            <form onSubmit={handleLogin}>
              <div className="fields">
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
              <button className="btn">Login</button>
            </form>
            <div className="existingUser">
              <p className="Alreadyaccount">
                Don't have an account? <Link to="/Register">Register here</Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Loginform;
