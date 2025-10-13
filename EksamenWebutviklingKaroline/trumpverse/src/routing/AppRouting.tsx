import { BrowserRouter, Routes, Route } from "react-router-dom";
import { HomePage, EditMerchPage, MerchPage, RegisterStaffPage, ShoppingCartPage, StaffPage, ThoughtsPage } from "../pages";
import MainNavigation from "../components/shared/MainNavigation";

const AppRouting = () => {
    return (
            <BrowserRouter>
                <MainNavigation/>
                    <Routes>
                        <Route path="/" element={<HomePage/>}/>
                        <Route path="thoughts" element={<ThoughtsPage/>}/>
                        <Route path="merch" element={<MerchPage/>}/>
                        <Route path="staff" element={<StaffPage/>}/>
                        <Route path="register-staff" element={<RegisterStaffPage/>}/>
                        <Route path="edit-merch" element={<EditMerchPage/>}/>
                        <Route path="shopping-cart" element={<ShoppingCartPage/>}/>
                    </Routes>
            </BrowserRouter>
    )
}

export default AppRouting;