import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '@/modules';
import { change } from '@/modules/changeBtn';
import OttBtn from '@/components/common/OttBtn';

const OttBtnContainer = ({ name, opt }: BtnProps) => {
  const current = useSelector((state: RootState) => state.changeBtn.current);
  const dispatch = useDispatch();

  const onChange = () => {
    if (opt === '') {
      dispatch(change(name));
      //console.log(current);
    }
  };

  return <OttBtn name={name} opt={opt} onChange={onChange} />;
};

type BtnProps = {
  name: string;
  opt: string;
};
export default OttBtnContainer;
