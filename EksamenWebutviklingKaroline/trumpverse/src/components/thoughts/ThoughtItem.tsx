import { FC, useContext } from "react";
import IThought from "../../interfaces/IThought";
import { ThoughtContext } from "../../contexts/ThoughtContext";
import IThoughtContext from "../../interfaces/IThoughtContext";

const ThoughtItem : FC<IThought> = ({id, title, content}) => {

    const {deleteThought} = useContext(ThoughtContext) as IThoughtContext;

    const handleDelete = () => {
        if (id != null) {
            console.log("Slettknappen er trykket på produktnr.: ", id)
            deleteThought(id);
        }
    }

    // https://getbootstrap.com/docs/4.2/components/card/
    return (
            <div className="card">
                <article className="background-box col-sm-12">
                    <h3 className="heading text-title m-4">{title}</h3>
                    <p className="text m-4">{content}</p>
                    <div>
                        <button type="button" className="btn btn-danger d-block mx-auto px-3 m-4" onClick={handleDelete}>Delete</button>
                    </div>
                </article>
            </div>
    )
}

export default ThoughtItem;