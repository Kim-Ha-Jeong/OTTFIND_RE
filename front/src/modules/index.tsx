import { combineReducers } from 'redux';
import changeBtn from '@/modules/changeBtn';
import setClick from '@/modules/setClick';
import setSearch from '@/modules/setSearch';
import setFilm from '@/modules/setFilm';

const rootReducer = combineReducers({
  changeBtn,
  setClick,
  setSearch,
  setFilm,
});

export default rootReducer;
export type RootState = ReturnType<typeof rootReducer>;
