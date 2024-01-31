import React from "react";
import { Link } from "react-router-dom";
import { ImCart } from "react-icons/im";


const Search = ({ cartItems }) => {
  window.addEventListener("scroll", function () {
    const search = document.querySelector(".search");
    search.classList.toggle("active", window.scrollY > 100);
  });

  return (
    <>
      <section className="search">
        <div className="container c_flex">
          <div className="logo width">
            <Link aria-label="Daraz Home" to="/">
              <img src="/assets/main-logo/logo.png" alt="" />
            </Link>
          </div>

          <div className="search-box f_flex">
            <i className="fa fa-search"></i>
            <input type="text" placeholder="Search here..." />
            <span>All Categories</span>
          </div>

          <div className="icon f_flex width">
            <Link aria-label="Login page" to="/login">
              <i className="fa fa-user icon-circle"></i>
            </Link>
            <div className="cart">
              <Link to="/cart">
                <i><ImCart /></i>
                <span>{cartItems.length === 0 ? 0 : cartItems.length}</span>
              </Link>
            </div>
          </div>
        </div>
      </section>
    </>
  );
};

export default Search;
