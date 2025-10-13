import RegisterStaff from "../components/staff/RegisterStaff";
import { StaffProvider } from "../contexts/StaffContext";

const RegisterStaffPage = () => {
    return(
        <section>
            <section className="row">
                <StaffProvider>
                    <RegisterStaff/>
                </StaffProvider>
            </section>
        </section>
    )
}

export default RegisterStaffPage;