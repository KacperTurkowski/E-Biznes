import './App.css';
import {Routes, Route, BrowserRouter as Router} from 'react-router-dom'
import StartPage from "./Components/StartPage/StartPage";
import CartPage from "./Components/CartPage/CartPage";
import OrdersPage from "./Components/OrdersPage/OrdersPage";

function App() {
  return (
      <div className="App">
        <Router>
          <Routes>
            <Route exact path="/" element={<StartPage/>}/>
            <Route exact path="/cart" element={<CartPage/>}/>
            <Route exact path="/orders" element={<OrdersPage/>}/>
          </Routes>
        </Router>
      </div>
  );
}

export default App;
