import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCartShopping} from "@fortawesome/free-solid-svg-icons"; 

const MainNavigation = () => {
    return (
        <header>
            <section className="mb-500">
                    <nav className=" me-auto navbar navbar-expand-lg navbar-light" style={{backgroundColor: "#ffffff", borderBottom: "0.8px solid #8c7039"}}>
                        <a className="navbar-brand" href="/">
                            <img src="./images/trump-icon.png" width="50" height="50" className="d-inline-block align-top" alt=""/>
                        </a>
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active"><Link className="nav-link" to="/" style={{ color: "#8c7039" }}>Home</Link></li>
                            <li className="nav-item active"><Link className="nav-link" to="thoughts" style={{ color: "#8c7039" }}>Thoughts</Link></li>
                            <li className="nav-item active"><Link className="nav-link" to="merch" style={{ color: "#8c7039" }}>Merch</Link></li>
                            <li className="nav-item active"><Link className="nav-link" to="edit-merch" style={{ color: "#8c7039" }}>Edit merch</Link></li> 
                            <li className="nav-item active"><Link className="nav-link" to="staff" style={{ color: "#8c7039" }}>Staff</Link></li>
                            <li className="nav-item active"><Link className="nav-link" to="register-staff" style={{ color: "#8c7039" }}>Register staff</Link></li> 
                        </ul>
                        <div className="d-flex align-items-center mr-2 ms-auto">
                            <Link className="nav-link" to="shopping-cart">
                                <FontAwesomeIcon icon={faCartShopping} style={{ color: "#8c7039", width: "2rem", height: "2rem", border: "#8c7039", backgroundColor: "white", position: "relative"}} aria-label="Icon of Shopping Cart." />
                            </Link>
                        </div>
                    </nav>
            </section>
        </header>
    )
}

export default MainNavigation;