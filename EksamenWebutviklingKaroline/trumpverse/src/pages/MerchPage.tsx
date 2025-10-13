import MerchList from "../components/merch/MerchList";
import { MerchProvider } from "../contexts/MerchContext";

const MerchPage = () => {
    return(
        <section>
            <MerchProvider>
                <MerchList/>
            </MerchProvider>
        </section>
    )
}

export default MerchPage;