
import './App.css'
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MainNavigation from './components/MainNavigation';
import { AddMerchPage, MerchPage, MerchSearchPage } from './pages';
import StartPage from './pages/StartPage';

//here i import all the different pages i have created to use the different functions
function App() {
  //using mainnavigation and routes to determine the paths
  //the navbar gets styles in the app.css file
  return (
    <Router>
      <MainNavigation/> 
      
      <Routes>
        <Route path="/" element={<StartPage/>} /> 
        <Route path="/register-merch" element={<AddMerchPage />} />
        <Route path="/merch-search" element={<MerchSearchPage />} />
        <Route path="/all-merch" element={<MerchPage />} />
      </Routes>
    </Router>
  );
}

export default App
