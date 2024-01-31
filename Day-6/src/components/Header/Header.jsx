import React from "react";
import Navbar from "./Navbar";
import Search from "./Search";
import "./Header.css";

const Header = ({ cartItems }) => {
  return (
    <>
      <Search cartItems={cartItems} />
      <Navbar />
    </>
  );
};

export default Header;
