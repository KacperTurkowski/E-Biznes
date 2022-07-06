import './App.css';
import {Routes, Route, BrowserRouter as Router} from 'react-router-dom'
import StartPage from "./Components/StartPage/StartPage";

function App() {
  return (
      <div className="App">
        <Router>
          <Routes>
            <Route exact path="/" element={<StartPage/>}/>
          </Routes>
        </Router>
      </div>
  );
}

export default App;
