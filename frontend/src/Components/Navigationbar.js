import React, { Component } from "react";
import {Button, Navbar, Nav, NavDropdown } from "react-bootstrap";
export default class Navigationbar extends Component {
  constructor(props){
    super(props);
  }

  handleOnClick = (url)=>{
    if(url == 1){
      window.location.replace("/");
    }else if(url == 2){
      window.location.replace("/profile");
    }else if(url ==3){
      window.location.replace("/signup");
    }else if(url == 4){
      window.location.replace("/login");
    }else{
      localStorage.removeItem("customerID");
      window.location.replace("/login");
    }
  }
	render() {
		return (
			<div>
				<header className="u-black u-clearfix u-header u-header" id="sec-aa26">
					<h1 className="u-text u-text-default u-text-1">BOOK DATE</h1>
				<Navbar bg="dark" variant="dark">
					<Nav className="mr-auto">
						<Nav.Link ><Button variant="warning" onClick={()=>this.handleOnClick(1)}>HOME</Button></Nav.Link>
						<Nav.Link ><Button variant="warning" onClick={()=>this.handleOnClick(2)}>SIGN UP</Button></Nav.Link>
            <Nav.Link ><Button variant="warning" onClick={()=>this.handleOnClick(3)}>PROFILE</Button></Nav.Link>
            {localStorage.getItem("customerID") != null ?
             <Nav.Link ><Button variant="warning" onClick={()=>this.handleOnClick(5)}>LOGOUT</Button></Nav.Link>
              :<Nav.Link ><Button variant="warning" onClick={()=>this.handleOnClick(5)}>LOGIN</Button></Nav.Link>}
            
					</Nav>
				</Navbar>
        </header>
			</div>
		);
	}
}
