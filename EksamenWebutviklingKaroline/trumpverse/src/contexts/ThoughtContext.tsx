import { useState, useEffect, createContext, FC } from "react";
import IThought from "../interfaces/IThought";
import IThoughtContext from "../interfaces/IThoughtContext";
import IProps from "../interfaces/IProp";
import ThoughtService from "../services/ThoughtService";

export const ThoughtContext = createContext<IThoughtContext | null>(null);

export const ThoughtProvider : FC<IProps> = ({children}) => {

    const [thoughts, setThoughts] = useState<IThought[]>([]);

    useEffect(()=>{
        getAndSetThoughts();
    }, []);

    const getAndSetThoughts = async () => {
        const thoughtList = await ThoughtService.getAll();
        if (thoughtList != null) {
            console.log(thoughtList);
            setThoughts(thoughtList);
        } 
        return null;
    }

    const getThoughtById = async (id: number) : Promise<IThought | null> => {
        if (id != null && id != undefined && id.toString().length > 0 ) {
            const thoughtById = await ThoughtService.getById(id);
            console.log(thoughtById);
            return thoughtById;
        }
        return null;
    }

    const getThoughtByTitle = async (title: string) : Promise<IThought | null> => {
        if (title != null && title != undefined && title.toLowerCase() ) {
            const thougthByTitle = await ThoughtService.getByTitle(title);
            console.log(thougthByTitle);
            return thougthByTitle;
        } 
            return null;
    }

    const postThought = async (newThought: IThought) : Promise<IThought | null> => {
        const result = await ThoughtService.postThought(newThought);
        if (result != null) {
            setThoughts([result, ...thoughts]);
        } 
        return result;
    }

    const putThought = async (updatedThought: IThought) : Promise<IThought | null> => {
        const result = await ThoughtService.putThought(updatedThought);
        if (result != null) {
            getAndSetThoughts();
            return updatedThought;
        }
        return null;
    }

    const deleteThought = async (id: number) => {
        await ThoughtService.deleteThought(id);
        getAndSetThoughts();
    }

    return(
        <ThoughtContext.Provider value={{thoughts, getThoughtById, getThoughtByTitle, postThought, putThought, deleteThought}}>
            {children}
        </ThoughtContext.Provider>
    )
}