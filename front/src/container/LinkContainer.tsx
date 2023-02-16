import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { RootState } from '@/modules';
import { change } from '@/modules/changeBtn';

import Link from '@/components/header/Link';

const LinkContainer = ({ id }: propsType) => {
  const current = useSelector((state: RootState) => state.changeBtn.current);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const changeType = (e: React.MouseEvent<HTMLDivElement>) => {
    const element = e.currentTarget as HTMLDivElement;
    navigate('/');
    dispatch(change(element.id));
  };

  return <Link changeType={changeType} id={id} current={current} />;
};

type propsType = {
  id: string;
};

export default LinkContainer;
