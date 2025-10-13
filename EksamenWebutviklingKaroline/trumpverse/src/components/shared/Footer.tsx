import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebookF, faYoutube, faInstagram, faTwitter } from '@fortawesome/free-brands-svg-icons';


// https://mdbootstrap.com/snippets/standard/mdbootstrap/2885115?view=side
// https://docs.fontawesome.com/v5/web/use-with/react

const Footer = () => {
  return (
    <div className="container my-5">
      <footer className="text-center text-lg-start" style={{ backgroundColor: "#ffffff" }}>
        <div className="container d-flex justify-content-center py-5">
          <button type="button" className="btn btn-secondary btn-lg btn-floating mx-2" style={{ backgroundColor: "#8c7039" }}>
            <a className='icon-link-color' href="https://www.facebook.com/DonaldTrump/" target='_blank'>
              <FontAwesomeIcon icon={faFacebookF} aria-label='Icon. Facebook'/>
            </a>
          </button>
          <button type="button" className="btn btn-secondary btn-lg btn-floating mx-2" style={{ backgroundColor: "#8c7039" }}>
            <a className='icon-link-color' href="https://www.youtube.com/@DonaldJTrumpforPresident/videos" target='_blank'>
              <FontAwesomeIcon icon={faYoutube} aria-label='Icon. Youtube'/>
            </a>
          </button>
          <button type="button" className="btn btn-secondary btn-lg btn-floating mx-2" style={{ backgroundColor: "#8c7039" }}>
            <a className='icon-link-color' href="https://www.instagram.com/realdonaldtrump/" target='_blank'>
              <FontAwesomeIcon icon={faInstagram} aria-label='Icon. Instagram'/>
            </a>
          </button>
          <button type="button" className="btn btn-secondary btn-lg btn-floating mx-2" style={{ backgroundColor: "#8c7039" }}>
            <a className='icon-link-color' href="https://x.com/realdonaldtrump" target='_blank'>
              <FontAwesomeIcon icon={faTwitter} aria-label='Icon. Twitter'/>
            </a>
          </button>
        </div>
        <div className="text-center text-black p-3" style={{ backgroundColor: "#ffffff", border: "0.8px solid #8c7039" }}>
          © 2024 Copyright: Trumpverse
        </div>
      </footer>
    </div>
  );
};

export default Footer;
