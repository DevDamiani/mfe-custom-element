import { useNavigate } from "react-router-dom";

export default function Tabs() {
  const navigate = useNavigate();

  return (
    <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
      <button onClick={() => navigate("/")}>Home</button>
      <button onClick={() => navigate("/about")}>About</button>
    </div>
  );
}
