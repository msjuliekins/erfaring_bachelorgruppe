import RegisterThougths from "../components/thoughts/RegisterThought";
import ThoughtList from "../components/thoughts/ThoughtList";
import { ThoughtProvider } from "../contexts/ThoughtContext";

const ThoughtsPage = () => {
    return(
            <section>
                <ThoughtProvider>
                    <RegisterThougths/>
                    <ThoughtList/>
                </ThoughtProvider>
            </section>
    )
}

export default ThoughtsPage;