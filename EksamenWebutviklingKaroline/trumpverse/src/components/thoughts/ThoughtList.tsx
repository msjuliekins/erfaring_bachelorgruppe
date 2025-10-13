import { useContext } from "react";
import { ThoughtContext } from "../../contexts/ThoughtContext";
import IThoughtContext from "../../interfaces/IThoughtContext";
import ThoughtItem from "./ThoughtItem";

const ThoughtList = () => {

    const {thoughts} = useContext(ThoughtContext) as IThoughtContext;

    const createAndGetThoughtsJSX = () => {
        const thoughtJSX = thoughts.map( (thought) => {
            return (
                <div className="text-center" key={thought.id}>
                    <ThoughtItem
                        id={thought.id}
                        title={thought.title}
                        content={thought.content}
                    />  
                </div>
            )
        } );
        return thoughtJSX;
    }

    return(
        <section>
            <section className="container mt-4">
                <div className="row g-3">
                    {createAndGetThoughtsJSX()}
                </div>
            </section>
        </section>
    )
}

export default ThoughtList;


