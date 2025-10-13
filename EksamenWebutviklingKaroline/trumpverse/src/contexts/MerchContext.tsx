import { useState, useEffect, createContext, FC } from "react";
import IMerch from "../interfaces/IMerch";
import IMerchContext from "../interfaces/IMerchContext"; 
import IProps from "../interfaces/IProp";
import MerchService from "../services/MerchService";

export const MerchContext = createContext<IMerchContext | null>(null);

export const MerchProvider : FC<IProps> = ({children}) => {
    const [merch, setMerch] = useState<IMerch[]>([]);

    useEffect(()=>{
        getAndSetMerch();
    }, []);

    const getAndSetMerch = async () => {
        const merchList = await MerchService.getAll();
        if (merchList != null) {
            console.log(merchList);
            setMerch(merchList);
        }
    }

    const getMerchById = async (id: number) : Promise<IMerch | null> => {
        if (id != null && id != undefined && id.toString().length > 0 ) {
            const merchById = await MerchService.getById(id);
            console.log(merchById);
            return merchById;
        } else {
            return null;
        }
    }

    const getMerchByName = async (name: string) : Promise<IMerch | null> => {
        if (name != null && name != undefined && name.toLowerCase() ) {
            const merchByName = await MerchService.getByName(name);
            console.log(merchByName);
            return merchByName;
        } else {
            return null;
        }
    }

    const postMerch = async (newMerch: IMerch) : Promise<IMerch | null> => {
        const result = await MerchService.postMerch(newMerch);
        if (result != null) {
            setMerch([result, ...merch]);
        }
        return result;
    }

    const putMerch = async (updatedMerch: IMerch) : Promise<IMerch | null> => {
        const result = await MerchService.putMerch(updatedMerch);
        if (result != null ) {
            getAndSetMerch();
            return updatedMerch;
        }
        return null;
    }

    const deleteMerch = async (id: number) => {
        await MerchService.deleteMerch(id);
        getAndSetMerch();
    }

    return(
        <MerchContext.Provider value={{merch, getMerchById, getMerchByName, postMerch, putMerch, deleteMerch}}>
            {children}
        </MerchContext.Provider>
    )
}