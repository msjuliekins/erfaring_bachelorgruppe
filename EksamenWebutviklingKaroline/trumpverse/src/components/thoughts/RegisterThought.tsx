import { useState, ChangeEvent, useContext, useEffect } from "react";
import IThoughtContext from "../../interfaces/IThoughtContext";
import { ThoughtContext } from "../../contexts/ThoughtContext";
import ThoughtService from "../../services/ThoughtService";
import ThoughtItem from "./ThoughtItem";

const RegisterThoughts = () => {

    const {thoughts, postThought} = useContext(ThoughtContext) as IThoughtContext;

    const [title, setTitle] = useState<string>("");
    const [content, setContent] = useState<string>("");
    const [newThoughtAdded, setNewThoughtAdded] = useState<any>("");

    useEffect(()=>{
        setNewThoughtAdded(newThoughtAdded);
    }, []);

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const {name} = e.target;
        switch(name) {
            case "title":
                console.log("Added title");
                setTitle(e.target.value);
            break;
            case "content":
                console.log("Added content");
                setContent(e.target.value);
        }
    }

    const createAndGetThoughtForm = () : React.ReactNode => {
        if (thoughts != null && thoughts != undefined && thoughts?.length > 0){
            const thoughtsJSX = thoughts?.map((thought) => {
                return(
                    <article key={thought.id}>
                    </article>
                    
                )
            });
            return thoughtsJSX;
        }
    }

    const getAndSetNewThought = () => {
        if(newThoughtAdded != null) {
            return(
                <div key={newThoughtAdded.id}>
                    <ThoughtItem
                        title={newThoughtAdded.title}
                        content={newThoughtAdded.content}
                    />
                </div>    
            )
        }
    }
    
    const registerThought = async () => {
        try{
            const newThought = {
                title: title,
                content: content
            };
    
            const result = await ThoughtService.postThought(newThought);
            if(result){
                console.log("New entry added")
                postThought(result);
                setNewThoughtAdded(result);
                setTitle("");
                setContent("");
            }
        } catch (e) {
            console.log("Feil ved registrering av innlegg")
        }
    }

    // https://getbootstrap.com/docs/4.1/components/forms/
    return(
        <section>
            <header className="flag-banner bottom-border">
                <h2 className="text-center display-3  mb-4">Trump's thoughts and wise words</h2>
            </header>
            <section className="background-box container d-flex justify-content-center align-items-center mt-4 border" style={{ width: "100%" }}>
                <form className="w-100">
                    <section className="ro g-3">
                        <article className="col-12">
                            <div className="form-group rounded p-2">
                                <label htmlFor="">Add title here</label>
                                <input className="form-control" type="text" name="title" onChange={handleChange} placeholder="Title"/>
                            </div>
                            <div className="form-group rounded p-2">
                                <label>Fill with text</label>
                                <input className="form-control" type="text" name="content" onChange={handleChange} placeholder="Content"/>
                        </div>
                        </article>
                    </section>
                    <div className="d-flex justify-content-center m-3">
                        <button className="save-btn" onClick={registerThought}> Save </button>
                    </div>
                </form>
                <section>
                    {createAndGetThoughtForm()}
                </section>
                <section>
                    {getAndSetNewThought()}
                </section>
            </section>
        </section>
    )

}

export default RegisterThoughts;