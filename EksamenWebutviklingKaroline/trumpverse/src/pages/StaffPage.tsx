import StaffList from "../components/staff/StaffList";
import { StaffProvider } from "../contexts/StaffContext";

const StaffPage = () => {
    return(
        <section>
            <StaffProvider>
                <StaffList/>
            </StaffProvider>
        </section>
        
    )
}

export default StaffPage;