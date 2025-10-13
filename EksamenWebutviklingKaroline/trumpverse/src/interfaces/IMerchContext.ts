import IMerch from "./IMerch";

interface IMerchContext {
    merch: IMerch[],
    getMerchById: (id: number) => Promise<IMerch | null>,
    getMerchByName: (name: string) => Promise<IMerch | null>,
    postMerch: (newMerch: IMerch) => Promise<IMerch | null>,
    putMerch: (updatedMerch: IMerch) => Promise<IMerch | null>,
    deleteMerch: (id: number) => void,
}

export default IMerchContext;