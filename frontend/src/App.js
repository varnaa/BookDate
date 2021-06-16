import logo from './logo.svg';
import './App.css';

function App() {
  return (
   <Router>
     <switch>
       <Route exact path="/" component={Home}/>
       <Route exact path="/login" component ={Login}/>
       <Route exact path="/signup" component = {Signup} />
       <Route exact path="/checkout" component={Checkout} />
       <Route exact path="/profile" component={Profile} />
     </switch>
   </Router>
  );
}

export default App;
