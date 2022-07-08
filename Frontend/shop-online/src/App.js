import './App.css';
import {Routes, Route, BrowserRouter as Router} from 'react-router-dom'
import StartPage from "./Components/StartPage/StartPage";
import CartPage from "./Components/CartPage/CartPage";

function App() {
  return (
      <div className="App">
        <Router>
          <Routes>
            <Route exact path="/" element={<StartPage/>}/>
            <Route exact path="/cart" element={<CartPage/>}/>
          </Routes>
        </Router>
      </div>
  );
}

export default App;
