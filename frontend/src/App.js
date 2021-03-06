import logo from './logo.svg';
import './App.css';
import React from  "react";
import Home from './Components/Home';
import Login from './Components/Login';
import Signup from './Components/Signup';
import Checkout from './Components/Checkout';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Profile from './Components/Profile';
function App() {
  return (
   <Router>
     <switch>
       <Route exact path="/" component={Home}/>
       <Route exact path="/login" component ={Login}/>
       <Route exact path="/signup" component = {Signup} />
       <Route exact path="/checkout/:planCode" component={Checkout} />
       <Route exact path="/profile" component={Profile} />
     </switch>
   </Router>
  );
}

export default App;
