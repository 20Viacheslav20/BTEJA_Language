
namespace Language.Models.DataTypes
{
    public class DataType
    {
        private readonly TypeEnum _type;

        private readonly ArrayType? _array;
        private DataType(TypeEnum type)
        {
            _type = type;
        }

        private DataType(ArrayType arrayInfo)
        {
            _type = TypeEnum.ARRAY;
            _array = arrayInfo;
        }

        public static readonly DataType INT = new DataType(TypeEnum.INT);

        public static readonly DataType REAL = new DataType(TypeEnum.REAL);

        public static readonly DataType STR = new DataType(TypeEnum.STR);

        public static readonly DataType BOOL = new DataType(TypeEnum.BOOL);

        public static DataType Array(DataType dataType, int size)
        {
            return new DataType(new ArrayType(dataType, size));
        }

        public bool IsArray()
        {
            return _type == TypeEnum.ARRAY;
        }

        public override string ToString()
        {
            return _type switch
            {
                TypeEnum.INT => "INT",
                TypeEnum.REAL => "REAL",
                TypeEnum.STR => "STR",
                TypeEnum.BOOL => "BOOL",
                TypeEnum.ARRAY => $"ARRAY {_array?.Size} OF {_array?.Type}",
                _ => throw new ArgumentOutOfRangeException()
            };
        }
    }
}
