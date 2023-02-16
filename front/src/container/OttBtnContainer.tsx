import { useDispatch } from 'react-redux';
import { change } from '@/modules/changeBtn';
import OttBtn from '@/components/common/OttBtn';

const OttBtnContainer = ({ name, opt }: BtnProps) => {
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
