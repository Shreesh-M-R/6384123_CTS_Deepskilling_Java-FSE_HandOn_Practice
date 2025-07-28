import './App.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div >
      <CalculateScore Name={"Shreesh"}
        School={"VHN Higher Secondary School"}
        total={446}
        outOf={600}
        goal={6} />
    </div>
  );
}

export default App;
