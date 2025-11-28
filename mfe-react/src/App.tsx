import { RouterProvider } from 'react-router-dom'
import { router } from './routes'

function App() {

  console.log({router});
  

  return (
    <RouterProvider router={router} />
  );
}

export default App
