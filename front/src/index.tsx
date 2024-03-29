import { createRoot } from 'react-dom/client';
import App from './App';

import { Provider } from 'react-redux';
import { createStore } from 'redux';
import rootReducer from '@/modules';

const container = document.getElementById('root');
const root = createRoot(container as Element);

const store = createStore(rootReducer);

root.render(
  <Provider store={store}>
    <App />
  </Provider>
);
