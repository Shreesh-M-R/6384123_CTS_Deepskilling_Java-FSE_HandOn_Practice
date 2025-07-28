import React from "react";
import { useParams } from "react-router-dom";
import trainers from "./TrainersMock";

const TrainerDetails = () => {
  const { id } = useParams();
  const trainer = trainers.find((t) => t.trainerId === id);

  if (!trainer) return <p>Trainer not found</p>;

  return (
    <div>
      <h2>Trainers Details</h2>
      <p><strong>{trainer.name} ({trainer.technology})</strong></p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetails;
