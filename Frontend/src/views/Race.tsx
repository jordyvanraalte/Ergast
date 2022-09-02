import { useParams } from 'react-router';
import Race from "../components/race/Race";



const RacePage: React.FC = () => {
    const { year, round } = useParams();
    return (<div>
        <Race />
    </div>)
}

export default RacePage;
