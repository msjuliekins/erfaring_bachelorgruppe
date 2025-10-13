import { Link } from "react-router-dom";


//this code sets the navigationponts that are being used in the nav-bar
const MainNavigation = () => {
    return (
        <nav>
            <ul>
                <li><Link to="/">Start</Link></li>
                <li><Link to="all-merch">All Merch</Link></li>
                <li><Link to="merch-search">Search Update and Delete</Link></li>
                <li><Link to="register-merch">Register new merch</Link></li>
            </ul>
        </nav>
    )
}

export default MainNavigation;