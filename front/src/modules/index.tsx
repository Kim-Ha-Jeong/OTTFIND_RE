import { combineReducers } from 'redux';
import changeBtn from '@/modules/changeBtn';

const rootReducer = combineReducers({
  changeBtn,
});

export default rootReducer;
export type RootState = ReturnType<typeof rootReducer>;
