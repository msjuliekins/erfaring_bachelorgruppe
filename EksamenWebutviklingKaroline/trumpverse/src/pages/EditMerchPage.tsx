import EditMerch from '../components/merch/EditMerch';
import { MerchProvider } from '../contexts/MerchContext';

const EditMerchPage = () => {
    return (
        <section>
            <MerchProvider>
                <EditMerch />
            </MerchProvider>
        </section>
    );
};

export default EditMerchPage;