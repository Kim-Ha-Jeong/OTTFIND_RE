import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import GlobalStyles from '@/styles/global-style';

import Main from '@/pages/main';

const App = () => {
  return (
    <Router>
      <GlobalStyles />
      <Routes>
        <Route path='/' element={<Main />} />
      </Routes>
    </Router>
  );
};

export default App;
