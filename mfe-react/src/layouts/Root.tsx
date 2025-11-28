import { Outlet } from "react-router-dom";
import Tabs from "../components/Tabs";

export default function Root() {

  return (
    <div>
      <Tabs/>
      <Outlet />
    </div>
  );
}
