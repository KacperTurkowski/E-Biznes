import './App.css';
import {Routes, Route, BrowserRouter as Router} from 'react-router-dom'
import StartPage from "./Components/StartPage/StartPage";
import CartPage from "./Components/CartPage/CartPage";
import OrdersPage from "./Components/OrdersPage/OrdersPage";
import LoginPage from "./Components/Login/Login";

function App() {
  return (
      <div className="App">
        <Router>
          <Routes>
            <Route exact path="/" element={<StartPage/>}/>
            <Route exact path="/cart" element={<CartPage/>}/>
            <Route exact path="/orders" element={<OrdersPage/>}/>
            <Route exact path="/login" element={<LoginPage/>}/>
          </Routes>
        </Router>
      </div>
  );
}

export default App;
