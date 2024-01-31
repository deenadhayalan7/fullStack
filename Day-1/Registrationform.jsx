import React, { useState } from "react";
import "../Loginform/LogReg.css";
import { Link, useNavigate} from "react-router-dom";


const Signup = () => {
  const navigate = useNavigate();
  const [input, setInput] = useState({
    name: "",
    email: "",
    password: "",
  });
  

  const handleSubmit = (e) =>{
      e.preventDefault();
      localStorage.setItem("Userdetail",JSON.stringify(input));
      navigate('/login');
  }
  return (
    <> 
    <div className="Signup">
      <div className="SignupContainer">
        <div className="child">
          <h1 className="heading">CREATE AN ACCOUNT</h1>
          <form  onSubmit={handleSubmit}>
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