import { useDispatch } from 'react-redux';
import { change } from '@/modules/changeBtn';

import { useNavigate } from 'react-router-dom';
import Header from '@/components/header/Header';

const HeaderContainer = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const moveHome = () => {
    dispatch(change('홈'));
    navigate('/');
  };

  return <Header moveHome={moveHome} />;
};

export default HeaderContainer;
